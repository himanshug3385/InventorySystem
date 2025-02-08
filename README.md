<body>
    <div class="container">
        <h1>Inventory Management System - API Documentation</h1>
        
   <h2>Tables</h2>
        <ul>
            <li><strong>Product</strong> - (productID [PK], name, stock)</li>
            <li><strong>Order</strong> - (OrderId [PK], productId, buyerId, quantity)</li>
            <li><strong>Buyer</strong> - (buyerId [PK], name)</li>
        </ul>

 <h2>1. Add Product Inventory</h2>
        <p><strong>Endpoint:</strong> <code>PUT /api/v1/product</code></p>
        <p><strong>Request:</strong></p>
        <pre><code>{
    "name": "Mobile",
    "stock": 54
}</code></pre>
        <p><strong>Response:</strong></p>
        <pre><code>{
    "productId": 1,
    "name": "Mobile",
    "stock": 64
}</code></pre>
        
 <h2>2. Onboard Buyer</h2>
        <p><strong>Endpoint:</strong> <code>PUT /api/v1/buyer</code></p>
        <p><strong>Request:</strong></p>
        <pre><code>{
    "name": "Himanshu Gupta"
}</code></pre>
        <p><strong>Response:</strong></p>
        <pre><code>{
    "buyerId": 2,
    "name": "Himanshu Gupta"
}</code></pre>
        
<h2>3. Order a Product</h2>
        <p><strong>Endpoint:</strong> <code>POST /api/v1/product/{productId}/buyer/{buyerId}/order</code></p>
        <p><strong>Request:</strong></p>
        <pre><code>{
    "quantity": 10
}</code></pre>
        <p><strong>Response:</strong></p>
        <pre><code>{
    "orderId": 2,
    "buyerId": 1,
    "productId": 1,
    "quantity": 10
}</code></pre>
        
  <h2>4. Get Stock Quantity</h2>
        <p><strong>Endpoint:</strong> <code>GET /api/v1/product/{productId}/stockinHand</code></p>
        <p><strong>Response:</strong> (integer value representing stock)</p>
        
  <h2>5. List All Buyers and Their Orders</h2>
        <p><strong>Endpoint:</strong> <code>GET /api/v1/product/order</code></p>
        <p><strong>Response:</strong></p>
        <pre><code>[
    {
        "buyerName": "Himanshu Gupta",
        "productName": "Mobile",
        "quantity": 1
    },
    {
        "buyerName": "Himanshu Gupta",
        "productName": "Mobile",
        "quantity": 10
    }
]</code></pre>
    </div>
</body>
