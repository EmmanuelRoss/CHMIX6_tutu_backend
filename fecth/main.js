/*
let url ="http://localhost:8080/api/productos/";
//endpoint
let productos = fetch(url);

productos
.then(elementos =>{
    console.log(elementos);
    return elementos.json();
})
.then(datos =>{
    console.log(datos);
})
.catch(error =>{
    console.log(error);
})
//traer la lista de productos ------------------
*/

/*
let url = 'http://localhost:8080/api/login/';
let data = {
    "nombre_usu": "Gustavo",
    "contrasenia": "gustavo"
};

fetch(url, {
  method: 'POST', // or 'PUT'
  body: JSON.stringify(data), // data can be `string` or {object}!
  headers:{
    'Content-Type': 'application/json'
  }
}).then(res => res.json())
.catch(error => console.error('Error:', error))
.then(response => console.log('Success:', response));
//para traer el token---------------------- 
*/

/*
let url = 'http://localhost:8080/api/productos/';
let data = {
    "nombre_prod": "sombrero violeta",
    "descripcion": "sombrero rojo",
    "url_imagen": "sadfgasdf.jpg",
    "talla": "l",
    "precio": 30.0,
    "cantidad_dis": 25,
    "categoria_idcategoria": 2
};


fetch(url, {
  method: 'POST', // or 'PUT'
  body: JSON.stringify(data), // data can be `string` or {object}!
  headers:{
    'Content-Type': 'application/json'
  }
}).then(res => res.json())
.catch(error => console.error('Error:', error))
.then(response => console.log('Success:', response));
//para guardar productos -----------------
*/