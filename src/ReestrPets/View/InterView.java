package ReestrPets.View;

import ReestrPets.Model.ParentAnimal;

public interface InterView {
    /**
     * Команды главного меню
     */
    enum MainMenuCommand {
        ADD_ANIMAL ("Добавить животное"),
        SHOW_SKILLS("Показать команды"),
        REMOVE_ANIMAL ("Убрать из базы"),
        EXIT ("Выйти");

        private String tag;

        MainMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    /**
     * Команды меню обучения командам
     */
    enum AddSkillMenuCommand {
        ADD_SKILL ("Обучить команде"),
        EXIT ("Выйти");

        private String tag;

        AddSkillMenuCommand(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    void showKennelRegistry();



    MainMenuCommand showMainMenuWithResult();


    boolean showAddAnimalDialog();


    int showRemoveAnimalDialog();


    void showDetailInfoAnimalDialog();


    void showAnimalInfo(ParentAnimal animal);


    AddSkillMenuCommand showAddSkillMenu(ParentAnimal animal);


    boolean showAddSkillDialog(ParentAnimal animal);
}

