let formProducto = document.getElementById("addProducto");

formProducto.addEventListener("submit", (e)=>{
  e.preventDefault();
  let nombre_prod = document.getElementById("nombre_prod");
  let descripcion = document.getElementById("descripcion");
  let url_imagen = document.getElementById("url_imagen");
  let talla = document.getElementById("talla");
  let precio = document.getElementById("precio");
  let cantidad_dis = document.getElementById("cantidad_dis");
  let categoria_idcategoria = document.getElementById("categoria_idcategoria");
  
  let nuevoProducto ={
      "nombre_prod" : nombre_prod.value,
      "descripcion" : descripcion.value,
      "url_imagen" : url_imagen.value,
      "talla" : talla.value,
      "precio" : precio.value,
      "cantidad_dis" : cantidad_dis.value,
      "categoria_idcategoria" : categoria_idcategoria.value
  }

  let url = 'http://localhost:8080/api/productos/';

fetch(url, {
  method: 'POST', // or 'PUT'
  body: JSON.stringify(nuevoProducto), // data can be `string` or {object}!
  headers:{
    'Content-Type': 'application/json'
  }
}).then(res => res.json())
.catch(error => console.error('Error:', error))
.then(response => console.log('Success:', response));
})


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