$("#submit").on("click", function (e) {
    e.preventDefault();
    var msg = "bank_ifsc_ code=" + $("#bank_ifsc_code").val()
        + "|bank_account_number=" + $("#bank_account_number").val()
        + "|amount=" + $("#amount").val() + "|merchant_transaction_ref="
        + $("#merchant_transaction_ref").val() + "|transaction_date="
        + $("#transaction_date").val() + "|payment_gateway_merchant_reference="
        + $("#payment_gateway_merchant_reference").val();
    var hash = getSHA(msg);
    var payload_with_sha = msg+"|hash="+hash;
    var payload_to_pg = encrypt(payload_with_sha);

    alert(payload_to_pg);
    $.ajax({
        method: "POST",
        url: "/transaction",
        data: "msg=" + payload_to_pg
    })
    .done(function (responce) {

    });
});

function encrypt(payload_with_sha) {
    var secret_key = "Q9fbkBF8au24C9wshGRW9utecYpyXye5vhFLtHFdGjRg3a4HxPYxPYRfKutZx5N4";
    return CryptoJS.AES.encrypt(payload_with_sha, secret_key);
}

function getSHA(msg) {
    return CryptoJS.SHA1(msg);
}

