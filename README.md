# REST-APIs---Documenting
Springboot aplication with Springfox dependecies and anotations for study

Swagger editor URL: https://editor.swagger.io/

SpringFox anotations in CategoriaResource, Categoria and Produto.

Dependencies: 

		<dependency> <!-- SpringFox -->
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.8.0</version>
			<scope>compile</scope>
		</dependency>
		<dependency> <!-- Swagger UI -->
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.8.0</version>
			<scope>compile</scope>
   </dependency>
   
Generated documentation access URLs: 
   
   Swagger UI form: http://localhost:8080/swagger-ui.html
   
   JSON form: http://localhost:8080/v2/api-docs 
   
Swagger Core annotations: https://github.com/swagger-api/swagger-core/wiki/Annotations
	
	@Api(description : "API Resource Description")
	@ApiOperation(value = "API Operation Description")
	@ApiModel(description = "Description for the model(Objetcs, Responses, Requests, Entities)")
	@ApiModelProperty(notes = "Description for the atribute(variable)")
	
