<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to the Good Project</title>
</head>

<body>

<input type="text" data-ng-model="searchString" placeholder="Enter vehicle id number"/>
<button data-ng-click="validateAndSubmit()">Search</button>

<div data-ng-class="{errors: validationResult, none: !validationResult}" data-ng-bind="validationResult"></div>
<div data-ng-show="cars">
    <div><h4> Results </h4></div>

    <div><i>Serial Number Pattern: </i><span><b>{{cars['Serial Number Pattern']}}</b></span></div>
    <div><i>Vehicle Trim Id: </i><span><b>{{cars['Vehicle Trim Id']}}</b></span></div>
    <div><i>Year: </i><span><b>{{cars['Vehicle Trim Id']}}</b></span></div>
    <div><i>Make: </i><span><b>{{cars['Year']}}</b></span></div>
    <div><i>Model: </i><span><b>{{cars['Model']}}</b></span></div>
    <div><i>Trim Name: </i><span><b>{{cars['Trim Name']}}</b></span></div>
</div>
</body>
</html>