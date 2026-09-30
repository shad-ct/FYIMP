class ThreadLifeCycle extends Thread {
    public void run() {
        try {
            System.out.println("Thread is running...");
            Thread.sleep(3000);
            System.out.println("Thread completed.");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifeCycle t = new ThreadLifeCycle();
        System.out.println("State after creation: " + t.getState());
        t.start();
        Thread.sleep(100);
        System.out.println("State while thread is active: " + t.getState());
        t.join();
        System.out.println("State after completion: " + t.getState());
    }
}
