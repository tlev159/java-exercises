package statemachine.typewriter;

public enum TypeWriterState {

  LOWERCASE {
    TypeWriterState next() {
      return TypeWriterState.UPPERCASE;
    }
  },
  UPPERCASE {
    TypeWriterState next() {
      return TypeWriterState.LOWERCASE;
    }
  };

  abstract TypeWriterState next();


}
