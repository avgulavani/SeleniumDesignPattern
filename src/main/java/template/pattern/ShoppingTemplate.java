package template.pattern;

public abstract class ShoppingTemplate {
	
	public abstract void openSite();
	public abstract void searchProdcut();
	public abstract void selectProduct();
	public abstract void buy();
	
	
	// this method is like template for shop
	public void shop()
	{
		openSite();
		searchProdcut();
		selectProduct();
		buy();
		
	}
	

}
