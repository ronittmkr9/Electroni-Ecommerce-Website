 <form action="../../category" method="POST">
     <div class="form-group inline">
            <div style="width: calc(50% - 5px);">
                <label for="fullName">Category Name:</label>
                <input type="text" id="categoryName" name="categoryName" required>
            </div>
            <div style="width: calc(50% - 5px);">
                <label for="user_name">Category Slug:</label>
                <input type="text" id="category_slug" name="categorySlug" required>
            </div>
        </div>
        <div class="form-group">
    <label>Do you want to be contacted?</label>
    <div>
        <label for="contact_yes">Yes</label>
        <input type="radio" id="contact_yes" name="status" value="1" required>
        
        <label for="contact_no">No</label>
        <input type="radio" id="contact_no" name="status" value="0">
    </div>
</div>
        <button type="submit" class="btn">Add category</button>
    </form>