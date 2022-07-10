let listDentists = document.querySelector("#dentists-table");
let showDentistsButton = document.querySelector("#show-dentists");

showDentistsButton.onclick = function () {
    listDentists.classList.remove("hide");
};
