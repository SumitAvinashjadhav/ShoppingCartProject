<%@page import="com.ecommerce.bean.CartItem"%>
<%@page import="java.text.DecimalFormat"%>

<!DOCTYPE html>
<html>
<head>
    <title>Payment</title>
    <script
		  src="https://code.jquery.com/jquery-3.7.1.min.js"
		  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		  crossorigin="anonymous">
    </script>
      <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
    <style>
       
    </style>
</head>
<body>
<div class="container">
    <h2>Payment</h2>
    
    
    <body>
  <%CartItem c=(CartItem)session.getAttribute("Cart"); %>
    
   <input type="text" id="user_id" name="userId" value=<%=c.getUserId() %>>
    <button onclick="paymentStart()">Pay</button>
  
  
</body>
<script>
  
  const paymentStart=()=>{
	
	  
	  let user_id=document.querySelector("#user_id").value;
	 
	  $.ajax({
		  url:"/EcommerceProject/paymentController?user_id="+user_id,
		  data:JSON.stringify({amount:1000,info:'order_request'}),
		  contentType:'application/json',
		  type:'POST',
		  dataType:'json',
		  success:function(response){
			  console.log("Hello");
			  console.log(response);
			  if(response.status=="created"){
				  var options = {
						  key: "rzp_test_HYCG9XE3B6gozQ", // Enter the Key ID generated from the Dashboard
						  amount: 1000, // Amount is in currency subunits. Default currency is
						 
						  currency: "INR",
						  name: "Payment Gateway Demo",
						  description: "Test Transaction",
						  image: "https://example.com/your_logo",
						  order_id: response.id,
						 
						  handler: function (response){
						  console.log(response.razorpay_payment_id);
						  console.log(response.razorpay_order_id);
						  console.log(response.razorpay_signature);
						  alert("Payment Successful");
						  },
						  
						  prefill: {
						  name: "",
						  email: "",
						  contact: ""
						  },
						 
						  note: {
						  "address": "Satara"

						  },
						 
						  theme: {
						  color: "#3399cc"
						  }
						  };
						 
				          var rzp = new Razorpay(options);
						  
						  rzp.open();
						 
			  
		  }
		  },
		  error:function(error){
			  console.log(error);
		  }
		  
	  })
	  
  }
  
  </script>
</div>
</body>
</html>
s