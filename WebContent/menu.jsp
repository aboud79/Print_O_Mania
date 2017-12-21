<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/tabs.css" />
<link rel="stylesheet" type="text/css" href="css/topbar.css" />
<link rel="stylesheet" type="text/css" href="css/searchbar.css" />
 <div class="page-sidebar ">

   
   <div id="mySidenav" class="sidenav">
  <h2 align = "center">Print_O_Mania</h2>
  <br>
  <br>
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()" >&times;</a>
  <br>
  <a href="#">Profile</a>
  <br>
  <a href="#">Products</a>
  <br>
  <a href="#">Design</a>
  <br>
  <a href="#">About</a>
</div>

<div id="main">
  
  <span style="font-size:20px;cursor:pointer" onclick="openNav()" id="buttondisp">&#9776;</span>
</div>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
    document.getElementById("buttondisp").style.display = "none";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
    document.getElementById("buttondisp").style.display = "inline";
}
</script>
  </div>