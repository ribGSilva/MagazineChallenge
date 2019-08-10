import { IngredientItem } from "./ingredientitem"

export interface Sandwich {
    name: String;
    image: String;
    ingredients: Array<IngredientItem>;
}