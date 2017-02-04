<%@page import="DataPhiLabs.bean.PatientBean" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entry Form</title>
<script src="../AngularJs/angular.min.js"></script>
<script src="../AngularJs/age.js"></script>
<link rel="stylesheet" href="../css/bootstrap.css">

<style>
header{
padding:5px;
padding-top:2px;
padding-right:4px;
margin:4px;
background-color: #29487d;
color:white;
}
</style>
</head>
<body ng-app="myApp" ng-controller ="myCntrl" style ="background-color :#f9f2f4">
<div class ="container-fluid">
<%  
List<PatientBean> list = new ArrayList<PatientBean>();


list = PatientBean.getPatient();

 %>
<header>
<h2>DataPhi Labs</h2>
</header>
<h4>Please Fill information about patient</h4>
<div class="row">
<div class="col-md-6">
<form name ="form" action = "../patientServlet" method="post">
  <div class="form-group">
    <label for="exampleInputField1">First Name</label>
     <input type="text" class="form-control" name="firstName" placeholder="Patient's FirstName"ng-model="firstName" ng-pattern ="/^[a-zA-z\s]*$/" required>
     <p class="help-block"  ng-show="form.firstName.$error.pattern" style = "color:red">*Username must be letters.</p>   
  </div>
  
 <div class="form-group">
    <label for="exampleInputField1">Last Name</label>
     <input type="text" class="form-control" name = "lastName" placeholder="Patient's LastName" ng-model="lastName" ng-pattern ="/^[a-zA-z\s]*$/" required>
     <p class="help-block" ng-show="form.lastName.$error.pattern" style = "color:red">*Username must be letters.</p>
  </div>
    
 <div class="col-md-6">
<div class="form-group">
  <label for="exampleInputField1">Date of Birth</label>
  <input type="date" class="form-control" name = "bday" placeholder="Patient's LastName" ng-model="bday" required>
 </div>
 </div>
 
 <div class="col-md-6">
 <div class="form-group">
  <label for="exampleInputField1">Age</label>
  <input type="text" class="form-control" name = "age" placeholder="age" ng-model="bday | ageFilter" readonly>
 </div>
 </div>
   
 <div class="col-md-6">
 <div class="form-group">
  <label for="exampleInputField1">Gender</label>
  <select class="form-control" id="sel1" name ="gender" required>
  <option value="">select gender</option>
  <option value= "male">male</option>
  <option value= "female">female</option>
  </select>
</div>
 </div>

 <div class="col-md-6">
 <div class="form-group">
  <label for="exampleInputField1">Phone</label>
     <input type="text" class="form-control" name="phone" placeholder="Phone" maxlength="10" ng-model="phone" ng-pattern ="/^[0-9\+]*$/" ng-minlength="10" required>
     <p class="help-block"  ng-show="form.phone.$error.pattern" style = "color:red">*Phone number must be numbers.</p>
     <p class="help-block" ng-if="form.phone.$error.minlength" style = "color:red">number is short.</p>
</div>
    </div>
    
     
    <div class="form-group">
    <textarea ng-model="textArea" placeholder="About Information"  class="form-control"name="textArea" maxlength="100" required ng-maxlength ="99" ng-minlength="1" ng-trim="false">
    </textarea>
    <p class="from-help" ng-if="!form.textArea.$error.maxlength">words are {{100-textArea.length}} left</p>
    <p class="help-block" ng-if="form.textArea.$error.maxlength" style = "color:red">limit of words is end.</p>
    </div>
 	
 
  <div class="form-group">
  <div class="col-md-6">
  <input type="submit" ng-disabled="!form.$valid" class="btn btn-primary btn-lg btn-block" value="submit">
  </div>
  <div class="col-md-6">
  <input type="button" class="btn btn-default btn-lg btn-block" ng-click="clear()" value="Reset">
  </div>
  </div>
</form>
</div>
<div class="col-lg-6">
<h3 style="color:#009688;">patient information from Data Base</h3>
<table class="table table-striped">
<th>Id
</th>
<th>First Name
</th>
<th>Last Name
</th>
<th>DOB
</th>
<th>Age
</th>
<th>Gender
</th>
<th>Contact
</th>
<th>About
</th>
<%
for(PatientBean lists : list)
{
%>
<tr>
<td><%=lists.getId() %>
</td>
<td><%=lists.getFirstName() %>
</td>
<td><%=lists.getLastName() %>
</td>
<td><%=lists.getBady() %>
</td>
<td><%=lists.getAge() %>
</td>
<td><%=lists.getGender() %>
</td>
<td><%=lists.getPhone() %>
</td>
<td><%=lists.getTextArea() %>
</td>
</tr>
<%} %>
</table>


</div>
</div>
</div>
</div>
</body>
</html>