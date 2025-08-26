$(function () {
  setActiveNav();
  setupSearch();
  setupAddUser();
  setupDeleteUser();
});

function setActiveNav() {
  var current = location.pathname.split("/").pop() || "index.html";
  $(".nav-link").each(function () {
    var end = $(this).attr("href").split("/").pop();
    if (end === current) {
      $(this).addClass("active");
    }
  });
}

function setupSearch() {
  if (!$("#search").length) return;
  $("#search").on("keyup", function () {
    var query = $(this).val().toLowerCase();
    $("#users-tbody tr").each(function () {
      var text = $(this).text().toLowerCase();
      $(this).toggle(text.indexOf(query) > -1);
    });
  });
}

function setupAddUser() {
  if (!$("#add-user-form").length) return;
  $("#add-user-form").on("submit", function (e) {
    e.preventDefault();
    var name = $("#new-name").val().trim();
    var email = $("#new-email").val().trim();
    if (!name || !email) return;
    appendUserRow(name, email);
    this.reset();
    $("#new-name").focus();
  });
}

function appendUserRow(name, email) {
  var row = `
    <tr>
      <td>${$("<div>").text(name).html()}</td>
      <td>${$("<div>").text(email).html()}</td>
      <td><button class="delete-btn">Delete</button></td>
    </tr>`;
  $("#users-tbody").append(row);
}

function setupDeleteUser() {
  $("#users-tbody").on("click", ".delete-btn", function () {
    var $row = $(this).closest("tr");
    var name = $row.find("td:first").text().trim();
    var ok = window.confirm('Delete user "' + name + '"?');
    if (ok) $row.fadeOut(150, function () { $(this).remove(); });
  });
}
