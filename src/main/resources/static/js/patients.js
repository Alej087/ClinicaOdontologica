let listPatients = document.querySelector("#patients-table");
let showPatientsButton = document.querySelector("#show-patients");

showPatientsButton.onclick = function () {
    listPatients.classList.remove("hide");
};
