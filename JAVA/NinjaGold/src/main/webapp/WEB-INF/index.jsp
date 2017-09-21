<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>Ninja Gold</title>
    <link rel="stylesheet" href="index.css" charset="utf-8">
  </head>
  <body>
    <div id="your_gold">
        <h3>Your Gold:</h3>
        <p><c:out value="${your_gold}"/></p>
    </div>
    <div id="wrapper">
        <div id="forms">
            <div class="farm">
                <h1>Farm</h1>
                <p> (earns 10-20 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="farm"/>
                <input type="submit" value="Find Gold!"/>
                </form>
            </div>

            <div class="cave">
                <h1>Cave</h1>
                <p> (earns 5-10 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="cave"/>
                <input type="submit" value="Find Gold!"/>
                </form>
            </div>

            <div class="house">
                <h1>House</h1>
                <p> (earns 2-5 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="house"/>
                <input type="submit" value="Find Gold!"/>
                </form>
            </div>

            <div class="casino">
                <h1>Casino</h1>
                <p> (earns/takes 0-50 golds)</p>
                <form action="/process_money" method="post">
                    <input type="hidden" name="building" value="casino"/>
                <input type="submit" value="Find Gold!"/>
                </form>
            </div>
        </div>
    </div>
    
    <div id="activities">
        <h2>Activities:</h2>
        		<ul>
        			<c:forEach items= "${allactivities}" var="item">
					<li>${item }</li>
				</c:forEach>
        		</ul>
    </div>

  </body>
</html>
