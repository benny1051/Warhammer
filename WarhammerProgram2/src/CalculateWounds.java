
    import java.beans.PropertyChangeEvent;
    import java.beans.PropertyChangeListener;
    import java.beans.PropertyChangeSupport;
    import java.util.ArrayList;
import java.util.Random;

    public class CalculateWounds {
        private final PropertyChangeSupport changes= new PropertyChangeSupport(this);
        private int bs;
        private int str;
        private int tough;
        private int save;
        private int numOfShots;
        private int numOfHits;
        private int numOfWounds;
        private int savedWound;
        private int AP;
        private int damageTaken;

        ArrayList<Integer> result;

        public CalculateWounds(int bs, int str, int tough, int save, int numOfShots, int AP) {
            this.bs = bs;
            this.str = str;
            this.tough = tough;
            this.save = save;
            this.numOfShots = numOfShots;
            this.AP= AP;
            result=new ArrayList<Integer>();
            CalculateNumberOfHits(bs);
        }

        public CalculateWounds() {

        }

        public void addPropertyChangeListener(PropertyChangeListener listener){
            changes.addPropertyChangeListener(listener);
        }
        public void removePropertyChangeListener(PropertyChangeListener listener){
            changes.removePropertyChangeListener(listener);
        }

        public void CalculateNumberOfHits(int bs) {
            Random random = new Random();

            for (int i = 0; i < numOfShots; i++) {
                int diceRoll = random.nextInt(6);
                diceRoll++;
                System.out.println(diceRoll);

                if (bs == 0 && diceRoll >= 2) {
                    numOfHits++;
                }
                if (bs == 1 && diceRoll >= 3) {
                    numOfHits++;
                }
                if (bs == 2 && diceRoll >= 4) {
                    numOfHits++;
                }
                if (bs == 3 && diceRoll >= 5) {
                    numOfHits++;
                }
                if (bs == 4 && diceRoll == 6) {
                    numOfHits++;
                }
            }

            CalculateNumOfWounds(numOfHits);
        }

        public void CalculateNumOfWounds(int numOfHits) {
            Random random = new Random();
            str++;
            tough++;
            for (int i = 0; i < numOfHits; i++) {
                int diceRoll = random.nextInt(6);
                diceRoll++;
                System.out.println(diceRoll);


                if (str == tough && diceRoll >= 4) {
                    numOfWounds++;
                }
                if (str > tough && str < (tough * 2) && diceRoll >= 3) {
                    numOfWounds++;
                }
                if (tough > str && tough < (str * 2) && diceRoll >= 5) {
                    numOfWounds++;
                }
                if (str >= (tough * 2) && diceRoll >= 2) {
                    numOfWounds++;
                }
                if (tough >= (str * 2) && diceRoll >= 6) {
                    numOfWounds++;
                }

            }
            calculateSaves(numOfWounds);


        }

        public void calculateSaves(int numOfWounds) {
            Random random = new Random();

            for (int i = 0; i < numOfWounds; i++) {
                int diceRoll = random.nextInt(6);
                diceRoll++;
                System.out.println(diceRoll);

                if (AP == 0) {
                    if (save == 0 && diceRoll >= 2) {
                        savedWound++;
                    }

                    if (save == 1 && diceRoll >= 2) {
                        savedWound++;
                    }

                    if (save == 2 && diceRoll >= 2) {
                        savedWound++;
                    }

                    if (save == 3 && diceRoll >= 3) {
                        savedWound++;
                    }

                    if (save == 4 && diceRoll >= 4) {
                        savedWound++;
                    }

                    if (save == 5 && diceRoll >= 5) {
                        savedWound++;
                    }

                    if (save == 6 && diceRoll == 6) {
                        savedWound++;
                    }
                }

                if (AP == 1) {
                    if (save == 0 && diceRoll >= 2) {
                        savedWound++;
                    }

                    if (save == 1 && diceRoll >= 2) {
                        savedWound++;
                    }

                    if (save == 2 && diceRoll >= 3) {
                        savedWound++;
                    }

                    if (save == 3 && diceRoll >= 4) {
                        savedWound++;
                    }

                    if (save == 4 && diceRoll >= 5) {
                        savedWound++;
                    }

                    if (save == 5 && diceRoll >= 6) {
                        savedWound++;


                    }
                }
                if (AP == 2) {
                    if (save == 0 && diceRoll >= 2) {
                        savedWound++;
                    }

                    if (save == 1 && diceRoll >= 3) {
                        savedWound++;
                    }

                    if (save == 2 && diceRoll >= 4) {
                        savedWound++;
                    }

                    if (save == 3 && diceRoll >= 5) {
                        savedWound++;
                    }

                    if (save == 4 && diceRoll >= 6) {
                        savedWound++;
                    }

                }
                if (AP == 3) {
                    if (save == 0 && diceRoll >= 3) {
                        savedWound++;
                    }

                    if (save == 1 && diceRoll >= 4) {
                        savedWound++;
                    }

                    if (save == 2 && diceRoll >= 5) {
                        savedWound++;
                    }

                    if (save == 3 && diceRoll >= 6) {
                        savedWound++;
                    }
                }
                if (AP == 4) {
                    if (save == 0 && diceRoll >= 4) {
                        savedWound++;
                    }

                    if (save == 1 && diceRoll >= 5) {
                        savedWound++;
                    }

                    if (save == 2 && diceRoll >= 6) {
                        savedWound++;
                    }
                }
                if (AP == 5) {
                    if (save == 0 && diceRoll >= 5) {
                        savedWound++;
                    }

                    if (save == 1 && diceRoll >= 6) {
                        savedWound++;
                    }
                }
            }

            damageTaken = (numOfWounds - savedWound);
            System.out.println("Number of hits " + numOfHits);
            System.out.println("Number of wounds " + numOfWounds);
            System.out.println("saves made " + savedWound);
            System.out.println("Wounds taken " + damageTaken);
            result.add(numOfHits);
            result.add(numOfWounds);
            result.add(savedWound);
            result.add(damageTaken);
            changes.firePropertyChange("message", false, result);


        }
    }
