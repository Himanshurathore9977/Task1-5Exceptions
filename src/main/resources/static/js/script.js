const paymentStart = () =>  {
    console.log(" Inside PaymentStart Function ");
    var amount = document.getElementById('amount').value;
    console.log(amount );
    if(amount === "" | amount == null ){
        alert("Amount is required ") ; 
        return ; 
    }

    // we will use ajax to send request to server to create request 
    // 
     
    $.ajax(
        {
            url : '/user/create-order',
            data:JSON.stringify( {amount : amount , info: 'order_request '}) , 
            contentType : 'application/json' , 
            type : "POST" , 
            dataType : "json" , 
            success:function(respone){

            }, 
            error:function(error){
                // invoked when error 
                console.log(error );
                alert("Something Went Wrong ") ; 
            }

        }
    )
} 
