function GerarMatricula() {
    const cursoSelecionado = document.getElementById("curso").value;
    const iniciais = {
        "Informatica": "INF",
        "Direito": "DIR",
        "Enfermagem": "ENF"
    };

    const inicialCurso = iniciais[cursoSelecionado] || "UNK";
    const ano = new Date().getFullYear();
    const aleatorio = Math.floor(100 + Math.random() * 900);

    const matricula = inicialCurso + "ACA" + ano + aleatorio;
    document.getElementById("matricula").value = matricula;
}