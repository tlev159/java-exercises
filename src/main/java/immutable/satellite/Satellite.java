package immutable.satellite;

public class Satellite {

  private CelestialCoordinates celestialCoordinates;
  private String registerIdent;

  public Satellite(CelestialCoordinates celestialCoordinates, String registerIdent) {
    if (registerIdent.isEmpty()) {
      throw new IllegalArgumentException("Register ident must not be empty!");
    }
    this.celestialCoordinates = celestialCoordinates;
    this.registerIdent = registerIdent;
  }

  public void modifyDestination(CelestialCoordinates diff) {
    celestialCoordinates = new CelestialCoordinates(celestialCoordinates.getX() + diff.getX(), celestialCoordinates.getY() + diff.getY(), celestialCoordinates.getZ() + diff.getZ());
  }

  public CelestialCoordinates getCelestialCoordinates() {
    return celestialCoordinates;
  }

  public String getRegisterIdent() {
    return registerIdent;
  }

  @Override
  public String toString() {
    return registerIdent + ": " + celestialCoordinates.toString();
  }
}
