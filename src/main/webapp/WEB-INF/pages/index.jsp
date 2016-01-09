<%--
  Created by IntelliJ IDEA.
  User: sardesh
  Date: 9/1/16
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Index page</title>
    <spring:url value="/resources/css/bootstrap.min.css" var="mainCss"/>
    <spring:url value="/resources/js/lib/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/js/lib/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/js/module/app.js" var="appJs"/>
    <link href="${mainCss}" rel="stylesheet"/>
</head>
<body>

<form role="form" class="col-lg-6 col-sm-6">
    <div class="form-group">
        <label>Ifsc code</label>
        <input type="text" class="form-control" id="bank_ifsc_code">
    </div>
    <div class="form-group">
        <label >Account Number</label>
        <input type="text" class="form-control" id="bank_account_number">
    </div>
    <div class="form-group">
        <label >Amount</label>
        <input type="text" class="form-control" id="amount">
    </div>
    <div class="form-group">
        <label >Merchant Transaction Ref</label>
        <input type="text" class="form-control" id="merchant_transaction_ref">
    </div>
    <div class="form-group">
        <label >Transaction Date</label>
        <input type="date" class="form-control" id="transaction_date">
    </div>
    <div class="form-group">
        <label >Payment Gateway Merchant Reference</label>
        <input type="text" class="form-control" id="payment_gateway_merchant_reference">
    </div>
    <button type="button" class="btn btn-default" id="submit">Submit</button>
</form>

<script src="${jqueryJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/sha1.js"></script>
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/aes.js"></script>
<script src="${appJs}"></script>
</body>
</html>
