<form action="../../product" method="post" enctype="multipart/form-data">
<!--     <input type="text" id="id" name="id"><br><br> -->
        <label for="fk_categoryID">Category ID:</label>
        <input type="number" id="fk_categoryID" name="fk_categoryID"><br><br>

        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName"><br><br>`

        <label for="productSlug">Product Slug:</label>
        <input type="text" id="productSlug" name="productSlug"><br><br>

        <label for="productImage">Product Image URL:</label>
<input type="file" name="productImage">

        <label for="productCostPrice">Cost Price:</label>
        <input type="text" id="productCostPrice" name="productCostPrice"><br><br>

        <label for="productRetailPrice">Retail Price:</label>
        <input type="text" id="productRetailPrice" name="productRetailPrice"><br><br>

        <label for="productQuantity">Quantity:</label>
        <input type="text" id="productQuantity" name="productQuantity"><br><br>

        <label for="productDescription">Description:</label><br>
        <textarea id="productDescription" name="productDescription" rows="4" cols="50"></textarea><br><br>

        <label>Product Status:</label><br>
        <input type="radio" id="active" name="productStatus" value="true">
        <label for="active">Active</label><br>
        <input type="radio" id="inactive" name="productStatus" value="false">
        <label for="inactive">Inactive</label><br><br>

        <input type="submit" value="Submit">
    </form>