<html>
<head>
  <title>Welcome!</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
  <h1>Welcome ${name}!</h1>
  <p>Our latest product:
  <a href="${url}">${desc}</a>!
  <ul>
  <#list all as x>
  	<li>${x}</li>
  </#list>
  </ul>
</body>
</html>