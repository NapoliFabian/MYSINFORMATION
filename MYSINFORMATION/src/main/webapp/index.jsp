<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">MYSINFORMATION</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Notizie</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="segnalazioniUtenti.jsp">Segnalazioni</a>
            </li>
            <li class="nav-item">
            <%
			boolean logged = false;
			if(session.getAttribute("isLogged") != null)
			{
				logged = (boolean) session.getAttribute("isLogged");
			}

		if(logged == false){
		%>

              <a class="nav-link" href="login.html">Accedi</a>
		<%} 
		else{
		%>
			<a class="nav-link" href="#">Account</a>
		<%
		}%>
            </li>
          </ul>
        </div>
      </nav>
      
      
      <form action= "ViewUtente" class="searchPage" method = "POST">
 		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">Testo</span>
  			<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name = "testo">
		</div>
 		<div class="input-group mb-3">
  			<span class="input-group-text" id="inputGroup-sizing-default">Fonte</span>
  			<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name = "fonte">
		</div>
		<div class="mb-3">
  			<label for="formFile" class="form-label">Carica una foto da verificare</label>
  			<input class="form-control" type="file" id="formFile">
		</div>
		<h6>Tipologia di notizia</h6>
		<select class="form-select" aria-label="Default select example">
  			<option selected>Testuale</option>
  			<option value="1">Immagine</option>
 			<option value="2">Video</option>
		</select>
		<br>
		<br>
		<br>
		<input type="submit" class="btn btn-primary" name= "UserAction" value="verifica">
	</form>
</body>
</html>