package po;

import java.util.List;

public class NewCategory {
private DCategory category;
private List<DCategory> categorylist;

public NewCategory() {
	super();

}

public NewCategory(DCategory category, List<DCategory> categorylist) {
	super();
	this.category = category;
	this.categorylist = categorylist;
}

public DCategory getCategory() {
	return category;
}
public void setCategory(DCategory category) {
	this.category = category;
}
public List<DCategory> getCategorylist() {
	return categorylist;
}
public void setCategorylist(List<DCategory> categorylist) {
	this.categorylist = categorylist;
}

}
