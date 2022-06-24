//----------------------------------------------------------------------------------------
    let campoTripulanteDeCabina = document.getElementById("campoTripulanteDeCabina");
    let campoCopiloto           = document.getElementById("campoCopiloto");
    let campoAvionCarga           = document.getElementById("campoAvionCarga");
    let campoAvionComercial           = document.getElementById("campoAvionComercial");
    let Checked                 = null;
    let ultimoValorValido       = null;
//----------------------------------------------------------------------------------------
    for (let CheckBox of document.getElementsByClassName("tipoAvion")){
        CheckBox.onclick = function(){
            if(Checked!=null){
                Checked.checked = false;
                Checked         = CheckBox;
            }
            Checked = CheckBox;
            //-------------------------
            if (Checked.id === "carga"){
                campoCopiloto.setAttribute("hidden", true);
                campoTripulanteDeCabina.setAttribute("hidden", true);
                campoAvionComercial.setAttribute("hidden", true);
            }else if (Checked.id !== "carga"){
                campoCopiloto.removeAttribute("hidden");
                campoTripulanteDeCabina.removeAttribute("hidden");
                campoAvionCarga.setAttribute("hidden", true);

                // $("#tripulantes").on("change", function() {
                //     if ($("#tripulantes option:checked").length > 2) {
                //         $("#tripulantes").val(ultimoValorValido);
                //     } else {
                //         ultimoValorValido = $("#tripulantes").val();
                //     }
                // });
            }
        }
    }
// --------------------------------------
    $('select').selectpicker();
// --------------------------------------
    let destino = document.getElementById("selectDestino");
    let origen  = document.getElementById("selectOrigen");
// ----------------------------------------------------------------
    origen.addEventListener("change", () => {
        for (let i = 0; i < destino.length; i++) {
            let opt = destino[i];
            if(opt.getAttribute ('disabled')!=null){
                opt.removeAttribute("disabled");
            }
            if(origen.value === opt.value){
                opt.setAttribute("disabled", "");
            }
        }
    })