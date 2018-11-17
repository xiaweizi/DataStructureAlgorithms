package stack;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : stack.StackTest2
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/11/15
 *     desc   :
 * </pre>
 */

class StackTest2 {
    String currentPage = "";
    LinkedStack<String> backStack;
    LinkedStack<String> forwardStack;

    StackTest2() {
        backStack = new LinkedStack<String>();
        forwardStack = new LinkedStack<String>();
    }

    void open(String url) {
        if (currentPage != null) {
            backStack.push(url);
            forwardStack.clear();
        }
        showPage(url, "open");
    }

    boolean canGoBack() {
        return !backStack.isEmpty();
    }

    boolean canGoForward() {
        return !forwardStack.isEmpty();
    }

    void goBack() {
        if (canGoBack()) {
            String back = backStack.pop();
            forwardStack.push(currentPage);
            showPage(back, "go back");
        }
    }

    void goForward() {
        if (canGoForward()) {
            String forward = forwardStack.pop();
            backStack.push(currentPage);
            showPage(forward, "go forward");
        }
    }

    void showCurrentPage() {
        System.out.println("current page url:\t" + currentPage);
    }


    void showPage(String url, String desc) {
        this.currentPage = url;
        System.out.println("current page url:\t" + this.currentPage + "  desc:\t" + desc);
    }

    public static void main(String[] args) {
        StackTest2 stack = new StackTest2();
        stack.open("http://www.baidu.com");
        stack.open("http://news.baidu.com/");
        stack.open("http://news.baidu.com/ent");
        stack.goBack();
        stack.goBack();
        stack.goForward();
        stack.open("http://www.qq.com");
        stack.goForward();
        stack.goBack();
        stack.goForward();
        stack.goBack();
        stack.goBack();
        stack.goBack();
        stack.goBack();
        stack.showCurrentPage();
    }
}
