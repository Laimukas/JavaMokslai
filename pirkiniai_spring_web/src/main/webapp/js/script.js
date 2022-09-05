function getAll() {
    fetch("ws/cekis", {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera duomenu";
        } else {
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function getOne() {
    const cekisId = document.getElementById("cekisId").value;
    fetch("ws/cekis/" + cekisId, {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("cekisId").value = data.id;
            document.getElementById("data").value = data.data;
            document.getElementById("parduotuve").value = data.parduotuve;
            document.getElementById("aprasymas").value = data.aprasymas;
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function update() {
    const cekisId = document.getElementById("cekisId").value;
    const cekisData = document.getElementById("data").value;
    const cekisParduotuve = document.getElementById("parduotuve").value;
    const cekisAprasymas = document.getElementById("aprasymas").value;
    const cekis = {
        id: cekisId,
        data: cekisData,
        parduotuve: cekisParduotuve
    };
    if (cekisAprasymas) {
        cekis.aprasymas = cekisAprasymas;
    }
    fetch("ws/cekis/" + cekisId, {
        method: "PUT",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cekis)
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "updated";
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function insert() {
    const cekisData = document.getElementById("data").value;
    const cekisParduotuve = document.getElementById("parduotuve").value;
    const cekisAprasymas = document.getElementById("aprasymas").value;
    const cekis = {
        data: cekisData,
        parduotuve: cekisParduotuve
    };
    if (cekisAprasymas) {
        cekis.aprasymas = cekisAprasymas;
    }
    fetch("ws/cekis", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cekis)
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("cekisId").value = data.id;
            document.getElementById("data").value = data.data;
            document.getElementById("parduotuve").value = data.parduotuve;
            document.getElementById("aprasymas").value = data.aprasymas;
            appDiv.innerHTML = "inserted: " + JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function deleteOne() {
    const cekisId = document.getElementById("cekisId").value;
    fetch("ws/cekis/" + cekisId, {
        method: "DELETE"
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "deleted";
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

//--------------------------------------------------------------

function getAllPrekes() {
    fetch("ws/preke", {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera duomenu";
        } else {
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function getOnePreke() {
    const prekeId = document.getElementById("prekeId").value;
    fetch("ws/preke/" + prekeId, {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("prekeId").value = data.id;
            document.getElementById("cekis").value = data.cekis;
            document.getElementById("preke").value = data.preke;
            document.getElementById("kaina").value = data.kaina;
            document.getElementById("kiekis").value = data.kiekis;
            document.getElementById("tipas").value = data.tipas;
            appDiv.innerHTML = JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function updatePreke() {
    const prekeId = document.getElementById("prekeId").value;
    const prekeCekis = document.getElementById("cekis").value;
    const prekePreke = document.getElementById("preke").value;
    const prekeKiekis = document.getElementById("kiekis").value;
    const prekeKaina = document.getElementById("kaina").value;
    const prekeTipas = document.getElementById("tipas").value;
    const preke = {
        id: prekeId,
        cekis: prekeCekis,
        preke: prekePreke,
        kiekis: prekeKiekis,
        kaina: prekeKaina,
        tipas: prekeTipas
    };
    fetch("ws/preke/" + prekeId, {
        method: "PUT",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(preke)
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "updated";
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function insertPreke() {
    const prekeCekis = document.getElementById("cekis").value;
    const prekePreke = document.getElementById("preke").value;
    const prekeKiekis = document.getElementById("kiekis").value;
    const prekeKaina = document.getElementById("kaina").value;
    const prekeTipas = document.getElementById("tipas").value;
    const preke = {
        cekis: prekeCekis,
        preke: prekePreke,
        kiekis: prekeKiekis,
        kaina: prekeKaina,
        tipas: prekeTipas
    };
    fetch("ws/preke", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(preke)
    })
    .then(response => {
        if (response.status >= 200 && response.status < 300) {
            if (response.status === 200) {
                return response.json();
            } else {
                return null;
            }
        }
        throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
    })
    .then(data => {
        const appDiv = document.getElementById("app");
        if (data === null) {
            appDiv.innerHTML = "Nera tokio";
        } else {
            document.getElementById("prekeId").value = data.id;
            document.getElementById("cekis").value = data.cekis;
            document.getElementById("preke").value = data.preke;
            document.getElementById("kiekis").value = data.kiekis;
            document.getElementById("kaina").value = data.kaina;
            document.getElementById("tipas").value = data.tipas;
            appDiv.innerHTML = "inserted: " + JSON.stringify(data);
        }
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}

function deleteOnePreke() {
    const prekeId = document.getElementById("prekeId").value;
    fetch("ws/preke/" + prekeId, {
        method: "DELETE"
    })
    .then(response => {
        if (response.status < 200 || response.status >= 300) {
            throw new Error(`Http klaida: ${response.status} (${response.statusText})`);
        }
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "deleted";
    })
    .catch(err => {
        const appDiv = document.getElementById("app");
        appDiv.innerHTML = "Klaida: " + err.message;
    });
}
