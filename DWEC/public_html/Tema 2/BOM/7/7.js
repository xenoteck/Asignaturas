/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var ventana;
var intervalo;


function crearW(){
    
    ventana = window.open("", "abrida", "width=200,height=80,left=500,top=500,menubar=no,location=no,resizable=0" );
    
    intervalo = setInterval(moveW,30);
    
}

function moveW(){
    
    ventana.moveBy(10,0);
    ventana.focus();
}

function pararW(){
    clearInterval(intervalo);
}


function borrarW(){
    ventana.close();
    pararW();
}