package com.tutuwix.tutu;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutuwix.tutu.model.Producto;




@SpringBootTest
@AutoConfigureMockMvc
class TutuApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Disabled("desabilitado temporalmente")
	public void pruebaPut() throws Exception{
		this.mockMvc.perform(put("/api/productos/5").queryParam("nombre_prod", "sombrero"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("sombrero") ) );
	}//pruebaPut
	
	@Test
	@Disabled("desabilitado temporalmente")
	public void pruebaDelete() throws Exception {
		this.mockMvc.perform(delete("/api/productos/5"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("sombrero") ) );
	}//pruebadelete
	
	@Test
	@Disabled("desabilitado temporalmente")
	public void pruebaPost() throws Exception {
		Producto p = new Producto();
		p.setNombre_prod("gorra morada");
		p.setPrecio(400.0);
		p.setDescripcion("gorra estilo ojo de dios");
		p.setUrl_imagen("gorra_morada.png");
		p.setTalla("xxxl");
		p.setCantidad_dis(20);
		p.setCategoria_idcategoria(1);
		
	this.mockMvc.perform(post("/api/productos/")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJsonString(p))).andExpect(status().isOk());
	}//pruebaPost
	
	public static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString

	@Test
	@Disabled("desabilitado temporalmente")
	public void pruebaGets() throws Exception {
		this.mockMvc.perform(get("/api/productos/10") )
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("gorra que parece sombrero") ) );
	}//pruebaGets

}
