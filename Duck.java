class Duck extends Bird implements Flyer, Swimmer {
  Console console = new Console();

  @Override
  public void fly() {
    console.log("Ducks can fly great distances when migrating");
  }

  @Override
  public void swim() {
    console.log("Ducks swim by paddling their feet under the water");
  }

  @Override
  public void dive() {
    console.log("Ducks can hold their breathe for several minutes when they dive for food");
  }
}