package contracts;

import enumeration.EngineType;
import exeptions.DuplicateModelException;

public interface EngineCreator {
    String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException;
}
