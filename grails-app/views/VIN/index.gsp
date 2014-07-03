<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to the Good Project</title>
</head>

<body>

<input type="text" data-ng-model="searchString" placeholder="enter vehicle id number"/>
<button data-ng-click="validateAndSubmit()">Search</button>

<div data-ng-class="{errors: validationResult, none: !validationResult}" data-ng-bind="validationResult"></div>
<div>{{cars}}</div>
</body>
</html>