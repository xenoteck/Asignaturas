/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var body = document.body;

var output = "<ul>";

output += "<li> Elementos a =" + getElementA(body) + "</li>";
output += "<li> Elementos a =" + getElementP(body) + "</li>";
output += "<li> Penultimo enlace =" + getUrlFromAPenultimate(body) + "</li>";
output += "<li> Penultimo enlace =" + getUrlFromLastA(body) + "</li>";
output += "<li> Cantidad de enlaces a http://prova  =" + cantidadEnlacesPorUrl(body, "http://prova") + "</li>";
output += "<li> Cantidad de enlaces en el paragrafo 1 =" + cantidadEnlacesPorP(1, body) + "</li>";
output += "<li> Cantidad de enlaces en el paragrafo 2 =" + cantidadEnlacesPorP(2, body) + "</li>";
output += "<li> Cantidad de enlaces en el paragrafo 3 =" + cantidadEnlacesPorP(3, body) + "</li>";
output += "<li> Cantidad de enlaces en el paragrafo 4 =" + cantidadEnlacesPorP(4, body) + "</li>";
output += "<li> Cantidad de enlaces en el paragrafo 5 =" + cantidadEnlacesPorP(5, body) + "</li>";
output += "<li> Cantidad de enlaces en el paragrafo 6 =" + cantidadEnlacesPorP(6, body) + "</li>";
output += "</ul>"

document.getElementById("info").innerHTML = output;


//Devuelve cantidad de elementos <a>
function getElementA(x) {

    return x.getElementsByTagName("a").length;

}

//Devuelve cantidad de elementos <p>
function getElementP(x) {

    return x.getElementsByTagName("p").length;

}


//Devuelve el enlace del penultimo <a>
function getUrlFromAPenultimate(x) {

    var enlaces = x.getElementsByTagName("a");
    var penultimoValor = getElementA(x) - 2;

    return enlaces[penultimoValor].getAttribute("href");

}

//Devuelve el enlace del ultimo <a>
function getUrlFromLastA(x) {

    var enlaces = x.getElementsByTagName("a");
    var ultimoValor = getElementA(x) - 1;

    return enlaces[ultimoValor].getAttribute("href");

}


//Devuelve la cantidad de veces que sale el enlace dado
function cantidadEnlacesPorUrl(x, enlace){
    
    var enlaces = x.getElementsByTagName("a");
    var cantidadRepetida = 0;
    var textoEnlace;
    
    for (var i = 0; i < enlaces.length-1; i++) {
        
        textoEnlace = enlaces[i].getAttribute("href");
        if(textoEnlace == enlace){
            cantidadRepetida++;
        }
        
    }
    
    return cantidadRepetida;
    
}

//Segun el indice dado y el body mostrara los a en la etiqueta p seleccionada
function cantidadEnlacesPorP(indice, x){
    
    var paragrafos = x.getElementsByTagName("p");
    indice -= 1;
    return paragrafos[indice].getElementsByTagName("a").length;
    
    
}