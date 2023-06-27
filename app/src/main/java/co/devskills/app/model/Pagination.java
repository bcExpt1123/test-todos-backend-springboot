package co.devskills.app.model;

public class Pagination {
    private int current;

    private int pageSize;

    public int getCurrent() {
        return current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
