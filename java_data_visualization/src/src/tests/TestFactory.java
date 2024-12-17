package src.tests;

public class TestFactory {
    public void testAll() {
        new TestList().run();
        new TestStack().run();
        new TestQueue().run();
        
        new TestTree().run();
    }

}
