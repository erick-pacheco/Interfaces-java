class Parrot extends Bird implements Flyer {
  Console console = new Console();
  
  @Override
  public void fly () {
    console.log("The Parrot is flying!");
  }
}