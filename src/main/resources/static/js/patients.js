const listPatients = document.querySelector("#patients-table");
const showPatientsButton = document.querySelector("#show-patients");
const urlPatients = "http://localhost:8080/v1/patients";

showPatientsButton.onclick = function () {
    listPatients.classList.remove("hide");
};

async function getPatients(url) {
    const respuesta = await fetch(url, {
        method: "GET",
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Request-Methods": "OPTIONS,GET,PUT,DELETE,POST",
            "Access-Control-Allow-Methods": "OPTIONS,GET,PUT,DELETE,POST",
            "Access-Control-Allow-Headers": "*",
        },
        //body: JSON.stringify(datos),
        mode: "cors",
    });
    console.log(respuesta);
}

getPatients(urlPatients);
