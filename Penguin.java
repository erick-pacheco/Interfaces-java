class Penguin extends Bird implements Swimmer {
  Console console = new Console();

  @Override
  public void swim() {
    console.log("Penguins are agile swimmers");
  }

  @Override
  public void dive() {
    console.log("Penguins can dive hundreds of feet to catch fish");
  }
}