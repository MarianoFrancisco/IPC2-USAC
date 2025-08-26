document.addEventListener("DOMContentLoaded", function init() {
  setActiveNav();
  setupSearch();
  setupAddUser();
  setupDeleteUser();
});

function setActiveNav() {
  var current = getCurrentPage();
  var links = document.querySelectorAll(".nav-link");
  links.forEach(function (a) {
    var href = a.getAttribute("href") || "";
    var end = href.split("/").pop();
    if (end === current) a.classList.add("active");
  });
}

function getCurrentPage() {
  var last = location.pathname.split("/").pop();
  return last || "index.html";
}

function setupSearch() {
  var search = document.getElementById("search");
  if (!search) return;

  search.addEventListener("keyup", function () {
    var query = search.value.toLowerCase();
    filterUsers(query);
  });
}

function filterUsers(query) {
  var tbody = document.getElementById("users-tbody");
  if (!tbody) return;

  var rows = tbody.querySelectorAll("tr");
  rows.forEach(function (tr) {
    var text = tr.innerText.toLowerCase();
    tr.style.display = text.indexOf(query) > -1 ? "" : "none";
  });
}

function setupAddUser() {
  var form = document.getElementById("add-user-form");
  if (!form) return;

  form.addEventListener("submit", function (e) {
    e.preventDefault();
    var name = (document.getElementById("new-name").value || "").trim();
    var email = (document.getElementById("new-email").value || "").trim();
    if (!isValidUser(name, email)) return;

    appendUserRow(name, email);
    resetAddForm();
  });
}

function isValidUser(name, email) {
  return name.length > 0 && email.length > 0;
}

function appendUserRow(name, email) {
  var tbody = document.getElementById("users-tbody");
  if (!tbody) return;

  var tr = document.createElement("tr");

  var tdName = document.createElement("td");
  tdName.textContent = name;

  var tdEmail = document.createElement("td");
  tdEmail.textContent = email;

  var tdActions = document.createElement("td");
  var btnDelete = document.createElement("button");
  btnDelete.textContent = "Delete";
  btnDelete.className = "delete-btn";
  tdActions.appendChild(btnDelete);

  tr.appendChild(tdName);
  tr.appendChild(tdEmail);
  tr.appendChild(tdActions);

  tbody.appendChild(tr);
}

function resetAddForm() {
  var form = document.getElementById("add-user-form");
  if (form) {
    form.reset();
    var nameInput = document.getElementById("new-name");
    if (nameInput) nameInput.focus();
  }
}

function setupDeleteUser() {
  var tbody = document.getElementById("users-tbody");
  if (!tbody) return;

  tbody.addEventListener("click", function (ev) {
    var target = ev.target;
    if (!target.classList.contains("delete-btn")) return;

    var row = target.closest("tr");
    if (!row) return;

    var nameCell = row.querySelector("td:first-child");
    var name = nameCell ? nameCell.textContent.trim() : "this user";

    var ok = window.confirm('Delete user "' + name + '"?');
    if (!ok) return;

    row.style.transition = "opacity 120ms ease";
    row.style.opacity = "0";
    setTimeout(function () {
      row.remove();
    }, 140);
  });
}
