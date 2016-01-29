package com.comoelagua.android.braille.model.daos;

import android.content.res.Resources;

import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.model.beans.Word;

import java.util.ArrayList;

public class WordsDao implements CrudDao {

    private Resources res;

    public WordsDao(Resources res) {
        this.res = res;
    }

    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }

    @Override
    public <T> ArrayList<T> read(ArrayList<Criteria> criteriaList) {
        boolean random = false;
        int length = 0;
        for(Criteria criteria : criteriaList) {
            if (criteria.getParameter() == "random") {
                random = true;
            }
            if (criteria.getParameter() == "length") {
                length = Integer.parseInt( criteria.getValue() );
            }
        }
        if (random && length > 0) {
            ArrayList<T> wordsList = (ArrayList<T>) readRandom(length);
            return wordsList;
        }
        return null;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    public ArrayList<Word> readRandom(int length) {
        ArrayList<Word> wordsList = readAll();
        ArrayList<Word> shortWordsList = new ArrayList<Word>();
        for(int i = 0; i < length; i++) {
            int randomNum = (int) (Math.random() * wordsList.size() );
            shortWordsList.add( wordsList.get(randomNum) );
        }
        return shortWordsList;
    }

    public ArrayList<Word> readAll() {
        ArrayList wordsList = new ArrayList<Word>();
        String[] wordsArray = res.getStringArray(R.array.words);
        for (int i = 0; i < wordsArray.length; i++) {
            wordsList.add( new Word(1 + i, wordsArray[i]) );
        }

        return wordsList;
    }

    public ArrayList<Word> readPhrasesRandom(int length) {
        ArrayList<Word> wordsList = readAllPhrases();
        ArrayList<Word> shortWordsList = new ArrayList<Word>();
        for(int i = 0; i < length; i++) {
            int randomNum = 1 + (int) (Math.random() * wordsList.size());
            shortWordsList.add( wordsList.get(randomNum) );
        }
        return shortWordsList;
    }

    public ArrayList<Word> readAllPhrases() {
        ArrayList phrasesList = new ArrayList<Word>();
        phrasesList.add(new Word(1, "A buen entendedor, pocas palabras bastan"));
        phrasesList.add(new Word(99, "A buenas horas mangas verdes "));
        phrasesList.add(new Word(99, "A bulto"));
        phrasesList.add(new Word(99, "A caballo regalado, no le mires el dentado"));
        phrasesList.add(new Word(99, "A Dios rogando y con el mazo dando"));
        phrasesList.add(new Word(99, "A falta de pan buenas son tortas"));
        phrasesList.add(new Word(99, "A fin de cuentas"));
        phrasesList.add(new Word(99, "A hangover"));
        phrasesList.add(new Word(99, "A la buena de Dios"));
        phrasesList.add(new Word(99, "A la fuerza ahorcan"));
        phrasesList.add(new Word(99, "A la vuelta de la esquina"));
        phrasesList.add(new Word(99, "A lo hecho, pecho"));
        phrasesList.add(new Word(99, "A mal tiempo, buena cara"));
        phrasesList.add(new Word(99, "A menos bulto, más claridad"));
        phrasesList.add(new Word(99, "A ojo de buen cubero"));
        phrasesList.add(new Word(99, "A otra cosa, mariposa"));
        phrasesList.add(new Word(99, "A otro perro con ese hueso"));
        phrasesList.add(new Word(99, "A palabras necias, oídos sordos"));
        phrasesList.add(new Word(99, "A palo seco"));
        phrasesList.add(new Word(99, "A perro flaco, todo son pulgas"));
        phrasesList.add(new Word(99, "A propósito"));
        phrasesList.add(new Word(99, "A quid"));
        phrasesList.add(new Word(99, "A quien a buen árbol se arrima, buena sombra le cobija"));
        phrasesList.add(new Word(99, "A quien madruga Dios le ayuda"));
        phrasesList.add(new Word(99, "A rey muerto, rey puesto"));
        phrasesList.add(new Word(99, "A todo cerdo le llega su San Martín"));
        phrasesList.add(new Word(99, "A vivir que son dos días"));
        phrasesList.add(new Word(99, "A wet blanket"));
        phrasesList.add(new Word(99, "Adonde fueres haz lo que vieres"));
        phrasesList.add(new Word(99, "Agua que no has de beber déjala correr"));
        phrasesList.add(new Word(99, "Ahogarse en un vaso de agua"));
        phrasesList.add(new Word(99, "Ahuecar el ala"));
        phrasesList.add(new Word(99, "Al pan, pan y al vino, vino"));
        phrasesList.add(new Word(99, "Al tun tun"));
        phrasesList.add(new Word(99, "Alguien que es más fácil saltarlo que darle la vuelta"));
        phrasesList.add(new Word(99, "Anda ya!"));
        phrasesList.add(new Word(99, "Anímate!"));
        phrasesList.add(new Word(99, "Arrimar el hombro"));
        phrasesList.add(new Word(99, "Arrojar perlas a los cerdos"));
        phrasesList.add(new Word(99, "Aunque la mona se vista de seda, mona se queda"));
        phrasesList.add(new Word(99, "Bajar la guardia"));
        phrasesList.add(new Word(99, "Better late than never"));
        phrasesList.add(new Word(99, "Bless you!"));
        phrasesList.add(new Word(99, "Bon apetit."));
        phrasesList.add(new Word(99, "Borracho"));
        phrasesList.add(new Word(99, "Borracho como una cuba"));
        phrasesList.add(new Word(99, "Cada maestrillo tiene su librillo"));
        phrasesList.add(new Word(99, "Cada mochuelo a su olivo"));
        phrasesList.add(new Word(99, "Caer en saco roto"));
        phrasesList.add(new Word(99, "Cálmate!"));
        phrasesList.add(new Word(99, "Cambiar de chaqueta"));
        phrasesList.add(new Word(99, "Cantar las cuarenta"));
        phrasesList.add(new Word(99, "Cargar con el mochuelo"));
        phrasesList.add(new Word(99, "Carpe Diem!"));
        phrasesList.add(new Word(99, "Cenceño"));
        phrasesList.add(new Word(99, "Cierra la puerta"));
        phrasesList.add(new Word(99, "Cojonudo"));
        phrasesList.add(new Word(99, "Como agua de mayo"));
        phrasesList.add(new Word(99, "¿Cómo es eso? ¿Por qué?"));
        phrasesList.add(new Word(99, "Como Pedro por su casa"));
        phrasesList.add(new Word(99, "Como un libro abierto"));
        phrasesList.add(new Word(99, "Con la iglesia hemos topado"));
        phrasesList.add(new Word(99, "Con la miel en los labios"));
        phrasesList.add(new Word(99, "Corpulento"));
        phrasesList.add(new Word(99, "Coser y cantar"));
        phrasesList.add(new Word(99, "Costar un huevo"));
        phrasesList.add(new Word(99, "Costar un ojo de la cara"));
        phrasesList.add(new Word(99, "Costar un riñón"));
        phrasesList.add(new Word(99, "Cría fama y échate a dormir"));
        phrasesList.add(new Word(99, "Cross your fingers"));
        phrasesList.add(new Word(99, "Cruzar los dedos"));
        phrasesList.add(new Word(99, "Cuando a uno le quedan 2 telediarios"));
        phrasesList.add(new Word(99, "Cuando algo es otro cantar"));
        phrasesList.add(new Word(99, "Cuando algo o alguien es la bomba"));
        phrasesList.add(new Word(99, "Cuando seas padre, comerás huevo"));
        phrasesList.add(new Word(99, "Dar en el clavo"));
        phrasesList.add(new Word(99, "Date prisa!"));
        phrasesList.add(new Word(99, "De bien nacidos es ser agradecidos"));
        phrasesList.add(new Word(99, "De cara a la galería"));
        phrasesList.add(new Word(99, "De nada (después de decir gracias)"));
        phrasesList.add(new Word(99, "De pocas carnes"));
        phrasesList.add(new Word(99, "De tal palo tal astilla"));
        phrasesList.add(new Word(99, "De verdad!"));
        phrasesList.add(new Word(99, "Déjame en paz"));
        phrasesList.add(new Word(99, "Delgaducho"));
        phrasesList.add(new Word(99, "Descojonarse"));
        phrasesList.add(new Word(99, "Diálogo de besugos"));
        phrasesList.add(new Word(99, "Dime cuánto (para comida o bebidas)"));
        phrasesList.add(new Word(99, "Dios los cría y ellos se juntan"));
        phrasesList.add(new Word(99, "Dorar la píldora"));
        phrasesList.add(new Word(99, "Dormir como un ceporro"));
        phrasesList.add(new Word(99, "Dormir la mona"));
        phrasesList.add(new Word(99, "Dormirse en los laureles"));
        phrasesList.add(new Word(99, "Echar leña al fuego"));
        phrasesList.add(new Word(99, "Echar margaritas a los cerdos"));
        phrasesList.add(new Word(99, "El fútbol es así"));
        phrasesList.add(new Word(99, "El hábito no hace al monje"));
        phrasesList.add(new Word(99, "El horno no está para bollos"));
        phrasesList.add(new Word(99, "El mismo perro con distinto collar"));
        phrasesList.add(new Word(99, "El mundo es un pañuelo"));
        phrasesList.add(new Word(99, "El que algo quiere, algo le cuesta"));
        phrasesList.add(new Word(99, "El que espera, desespera"));
        phrasesList.add(new Word(99, "El que la sigue la consigue"));
        phrasesList.add(new Word(99, "El que mucho abarca poco aprieta"));
        phrasesList.add(new Word(99, "El que quiera peces que se moje el culo"));
        phrasesList.add(new Word(99, "El quinto pino"));
        phrasesList.add(new Word(99, "El talón de Aquiles"));
        phrasesList.add(new Word(99, "El uno por el otro la casa sin barrer"));
        phrasesList.add(new Word(99, "En boca cerrada no entran moscas"));
        phrasesList.add(new Word(99, "En casa de herrero, cuchillo de palo"));
        phrasesList.add(new Word(99, "En el reino de los ciegos, el tuerto es el rey"));
        phrasesList.add(new Word(99, "En mi opinión"));
        phrasesList.add(new Word(99, "En peores garitas hemos hecho guardia"));
        phrasesList.add(new Word(99, "En todas partes cuecen habas"));
        phrasesList.add(new Word(99, "Enjuto"));
        phrasesList.add(new Word(99, "Entre ceja y ceja"));
        phrasesList.add(new Word(99, "Entre pitos y flautas"));
        phrasesList.add(new Word(99, "Éramos pocos y parió la abuela"));
        phrasesList.add(new Word(99, "Es peor el remedio que la enfermedad"));
        phrasesList.add(new Word(99, "Estar en la gloria"));
        phrasesList.add(new Word(99, "Escuálido"));
        phrasesList.add(new Word(99, "Escurrir el bulto"));
        phrasesList.add(new Word(99, "Estar acojonado"));
        phrasesList.add(new Word(99, "Estar borracho"));
        phrasesList.add(new Word(99, "Estar cascado"));
        phrasesList.add(new Word(99, "Estar cogido con alfileres"));
        phrasesList.add(new Word(99, "Estar cogido con pinzas"));
        phrasesList.add(new Word(99, "Estar como el quico"));
        phrasesList.add(new Word(99, "Estar como pez en el agua"));
        phrasesList.add(new Word(99, "Estar como una cuba"));
        phrasesList.add(new Word(99, "Estar de buen año"));
        phrasesList.add(new Word(99, "Estar de buen ver"));
        phrasesList.add(new Word(99, "Estar de miranda"));
        phrasesList.add(new Word(99, "Estar entrado en carnes"));
        phrasesList.add(new Word(99, "Estar entre los brazos de Morfeo"));
        phrasesList.add(new Word(99, "Estar espeso"));
        phrasesList.add(new Word(99, "Estar flaco"));
        phrasesList.add(new Word(99, "Estar hasta los cojones"));
        phrasesList.add(new Word(99, "Estar hecho un cristo"));
        phrasesList.add(new Word(99, "Estar hecho un flan"));
        phrasesList.add(new Word(99, "Estar hecho un trapo"));
        phrasesList.add(new Word(99, "Estar hermoso"));
        phrasesList.add(new Word(99, "Estar para mojar pan"));
        phrasesList.add(new Word(99, "Estar patas arriba"));
        phrasesList.add(new Word(99, "Estar piripi"));
        phrasesList.add(new Word(99, "Estar rollizo"));
        phrasesList.add(new Word(99, "Estar siempre con la misma canción"));
        phrasesList.add(new Word(99, "Estar tan delgado que llueve y no te mojas"));
        phrasesList.add(new Word(99, "Estar zamproño"));
        phrasesList.add(new Word(99, "Estás de broma"));
        phrasesList.add(new Word(99, "Esto es Jauja"));
        phrasesList.add(new Word(99, "Faltar un tornillo"));
        phrasesList.add(new Word(99, "Ha pasado un ángel"));
        phrasesList.add(new Word(99, "Haber pillado un buen pedal"));
        phrasesList.add(new Word(99, "Hablando del rey de Roma"));
        phrasesList.add(new Word(99, "Hablando del rey de Roma, por la puerta asoma"));
        phrasesList.add(new Word(99, "Hablar por los codos"));
        phrasesList.add(new Word(99, "Hacer algo a troche y moche"));
        phrasesList.add(new Word(99, "Hacer borrón y cuenta nueva"));
        phrasesList.add(new Word(99, "Hacer buenas migas"));
        phrasesList.add(new Word(99, "Hacer bulto"));
        phrasesList.add(new Word(99, "Hacer el mono"));
        phrasesList.add(new Word(99, "Hacer la cabra"));
        phrasesList.add(new Word(99, "Hacer la pelota"));
        phrasesList.add(new Word(99, "Hacer la visita del médico"));
        phrasesList.add(new Word(99, "Hacer leña del árbol caído"));
        phrasesList.add(new Word(99, "Hacerse el sueco"));
        phrasesList.add(new Word(99, "Hacerse el sueco"));
        phrasesList.add(new Word(99, "Hacerse la boca agua"));
        phrasesList.add(new Word(99, "Hacía un frío de cojones"));
        phrasesList.add(new Word(99, "Hasta el rabo todo es toro"));
        phrasesList.add(new Word(99, "Hondonadas de hostias"));
        phrasesList.add(new Word(99, "Hostia"));
        phrasesList.add(new Word(99, "Hoy por ti mañana por mí"));
        phrasesList.add(new Word(99, "Ir a toda hostia"));
        phrasesList.add(new Word(99, "Ir al grano"));
        phrasesList.add(new Word(99, "Ir bien cocido"));
        phrasesList.add(new Word(99, "Ir bolinga"));
        phrasesList.add(new Word(99, "Ir ciego"));
        phrasesList.add(new Word(99, "Ir con pies de plomo"));
        phrasesList.add(new Word(99, "Ir ebrio"));
        phrasesList.add(new Word(99, "Ir hecho un Ecce Homo"));
        phrasesList.add(new Word(99, "Ir mamado"));
        phrasesList.add(new Word(99, "Ir pisando huevos"));
        phrasesList.add(new Word(99, "Irse bebiendo hasta el agua de los floreros"));
        phrasesList.add(new Word(99, "Irse con la música a otra parte"));
        phrasesList.add(new Word(99, "Irse por los cerros de Úbeda"));
        phrasesList.add(new Word(99, "Jesús! (cuando alguien estornuda)"));
        phrasesList.add(new Word(99, "La avaricia rompe el saco"));
        phrasesList.add(new Word(99, "La cabra siempre tira al monte"));
        phrasesList.add(new Word(99, "La esperanza es lo último que se pierde"));
        phrasesList.add(new Word(99, "La gota que colmó el vaso"));
        phrasesList.add(new Word(99, "La media naranja"));
        phrasesList.add(new Word(99, "La pescadilla que se muerde la cola"));
        phrasesList.add(new Word(99, "Lágrimas de cocodrilo"));
        phrasesList.add(new Word(99, "Le costó mil pares de huevos"));
        phrasesList.add(new Word(99, "Le ha salido el tiro por la culata"));
        phrasesList.add(new Word(99, "Leave me alone"));
        phrasesList.add(new Word(99, "Let the cat out of the bag"));
        phrasesList.add(new Word(99, "Let’s have one for the road"));
        phrasesList.add(new Word(99, "Liarse la manta a la cabeza"));
        phrasesList.add(new Word(99, "Ligar con alguien"));
        phrasesList.add(new Word(99, "Llegar y besar el santo"));
        phrasesList.add(new Word(99, "Llevar la voz cantante"));
        phrasesList.add(new Word(99, "Llevar los pantalones"));
        phrasesList.add(new Word(99, "Llevar un buen melocotón"));
        phrasesList.add(new Word(99, "Llevar un buen pedo o ir pedo perdido"));
        phrasesList.add(new Word(99, "Llevar un buen puntazo"));
        phrasesList.add(new Word(99, "Llevar una buena cogorza"));
        phrasesList.add(new Word(99, "Llevar una buena melopea"));
        phrasesList.add(new Word(99, "Llevar una buena mierda encima"));
        phrasesList.add(new Word(99, "Llevarse como el perro y el gato"));
        phrasesList.add(new Word(99, "Llevarse el gato al agua"));
        phrasesList.add(new Word(99, "Llover a mares o llover a cántaros"));
        phrasesList.add(new Word(99, "Llueve sobre mojado"));
        phrasesList.add(new Word(99, "Lo haré por cojones"));
        phrasesList.add(new Word(99, "Lo mereces"));
        phrasesList.add(new Word(99, "Los huevos, ingrediente indispensable de muchas expresiones españolas"));
        phrasesList.add(new Word(99, "Magro"));
        phrasesList.add(new Word(99, "Mal de muchos, consuelo de tontos"));
        phrasesList.add(new Word(99, "Mala hierba nunca muere"));
        phrasesList.add(new Word(99, "Manga por Hombro"));
        phrasesList.add(new Word(99, "Más claro que el agua"));
        phrasesList.add(new Word(99, "Más vale pájaro en mano que ciento volando"));
        phrasesList.add(new Word(99, "Más vale tarde que nunca"));
        phrasesList.add(new Word(99, "Más vale tarde que nunca"));
        phrasesList.add(new Word(99, "Más vale tarde que nunca"));
        phrasesList.add(new Word(99, "Matar dos pájaros de un tiro"));
        phrasesList.add(new Word(99, "Matar el gusanillo"));
        phrasesList.add(new Word(99, "Matar moscas a cañonazos"));
        phrasesList.add(new Word(99, "Me estás tomando el pelo"));
        phrasesList.add(new Word(99, "Me ha salido rana"));
        phrasesList.add(new Word(99, "Me importa 3 huevos"));
        phrasesList.add(new Word(99, "Me sabe mal"));
        phrasesList.add(new Word(99, "Me salió de cojones"));
        phrasesList.add(new Word(99, "Me suena"));
        phrasesList.add(new Word(99, "Me toca los huevos"));
        phrasesList.add(new Word(99, "Meter el dedo en la llaga"));
        phrasesList.add(new Word(99, "Meter cizaña"));
        phrasesList.add(new Word(99, "Meter la pata"));
        phrasesList.add(new Word(99, "Miel sobre hojuelas"));
        phrasesList.add(new Word(99, "Mojar"));
        phrasesList.add(new Word(99, "Mojar a alguien"));
        phrasesList.add(new Word(99, "Mojar la cama"));
        phrasesList.add(new Word(99, "Mojar la camiseta"));
        phrasesList.add(new Word(99, "Mojar un evento"));
        phrasesList.add(new Word(99, "Mojarse"));
        phrasesList.add(new Word(99, "Monto un circo y me crecen los enanos"));
        phrasesList.add(new Word(99, "Morir de éxito"));
        phrasesList.add(new Word(99, "Mucho ruido y pocas nueces"));
        phrasesList.add(new Word(99, "Muerto el perro, se acabó la rabia"));
        phrasesList.add(new Word(99, "Ni fu ni fa"));
        phrasesList.add(new Word(99, "Ni harto de vino"));
        phrasesList.add(new Word(99, "Ni me va ni me viene"));
        phrasesList.add(new Word(99, "No dar el brazo a torcer"));
        phrasesList.add(new Word(99, "No dar un palo al agua"));
        phrasesList.add(new Word(99, "No dejes para mañana lo que puedas hacer hoy"));
        phrasesList.add(new Word(99, "No es oro todo lo que reluce"));
        phrasesList.add(new Word(99, "No faltaría mas"));
        phrasesList.add(new Word(99, "No hay mal que por bien no venga"));
        phrasesList.add(new Word(99, "No hay peor ciego que el que no quiere ver"));
        phrasesList.add(new Word(99, "No me extraña"));
        phrasesList.add(new Word(99, "No pegar ojo"));
        phrasesList.add(new Word(99, "No pegar ni con cola"));
        phrasesList.add(new Word(99, "No por mucho madrugar, amanece más temprano"));
        phrasesList.add(new Word(99, "No se hizo la miel para la boca del asno"));
        phrasesList.add(new Word(99, "No se puede vender la piel del oso antes de cazarlo"));
        phrasesList.add(new Word(99, "No ser trigo limpio"));
        phrasesList.add(new Word(99, "No sólo de pan vive el hombre"));
        phrasesList.add(new Word(99, "No tener abuela"));
        phrasesList.add(new Word(99, "No tengo ni idea"));
        phrasesList.add(new Word(99, "No todo el monte es orégano"));
        phrasesList.add(new Word(99, "No wonder"));
        phrasesList.add(new Word(99, "Nos ha salido redondo"));
        phrasesList.add(new Word(99, "Nos ha tocado el gordo"));
        phrasesList.add(new Word(99, "Nunca digas de este agua no beberé"));
        phrasesList.add(new Word(99, "Obeso"));
        phrasesList.add(new Word(99, "Ojalá"));
        phrasesList.add(new Word(99, "Ojos que no ven, corazón que no siente"));
        phrasesList.add(new Word(99, "Olerse la tostada"));
        phrasesList.add(new Word(99, "Otro gallo cantaría"));
        phrasesList.add(new Word(99, "Pagar en efectivo"));
        phrasesList.add(new Word(99, "Pan para hoy y hambre para mañana"));
        phrasesList.add(new Word(99, "Parecer un spaguetti"));
        phrasesList.add(new Word(99, "Pasar página"));
        phrasesList.add(new Word(99, "Pasar por el aro"));
        phrasesList.add(new Word(99, "Pasarse 3 pueblos"));
        phrasesList.add(new Word(99, "Pedirle peras al olmo"));
        phrasesList.add(new Word(99, "Perder el Norte"));
        phrasesList.add(new Word(99, "Perro ladrador poco mordedor"));
        phrasesList.add(new Word(99, "Pillar una tajada o ir con la tajá"));
        phrasesList.add(new Word(99, "Pingüe"));
        phrasesList.add(new Word(99, "Pintar la mona"));
        phrasesList.add(new Word(99, "Piropos"));
        phrasesList.add(new Word(99, "Poner cara de póquer"));
        phrasesList.add(new Word(99, "Poner los huevos sobre la mesa"));
        phrasesList.add(new Word(99, "Poner los puntos sobre las íes"));
        phrasesList.add(new Word(99, "Ponerse las pilas"));
        phrasesList.add(new Word(99, "Ponerse morado"));
        phrasesList.add(new Word(99, "Por H o por B"));
        phrasesList.add(new Word(99, "Por la boca muere el pez"));
        phrasesList.add(new Word(99, "Por si las moscas"));
        phrasesList.add(new Word(99, "Por supuesto"));
        phrasesList.add(new Word(99, "Porque hoy es hoy"));
        phrasesList.add(new Word(99, "Qué aproveche o Buen provecho"));
        phrasesList.add(new Word(99, "Qué cara!"));
        phrasesList.add(new Word(99, "Qué lío!"));
        phrasesList.add(new Word(99, "Que me quiten lo bailao"));
        phrasesList.add(new Word(99, "Que si quieres arroz Catalina"));
        phrasesList.add(new Word(99, "Qué timo!"));
        phrasesList.add(new Word(99, "Quedarse a cuadros"));
        phrasesList.add(new Word(99, "Quedarse con la copla"));
        phrasesList.add(new Word(99, "Quedarse en el tintero"));
        phrasesList.add(new Word(99, "Quedarse frito"));
        phrasesList.add(new Word(99, "Quédate con el cambio"));
        phrasesList.add(new Word(99, "Quien evita la ocasión evita el peligro"));
        phrasesList.add(new Word(99, "Quien siembra vientos recoge tempestades"));
        phrasesList.add(new Word(99, "Rascarse la barriga"));
        phrasesList.add(new Word(99, "Really!"));
        phrasesList.add(new Word(99, "Revelar un secreto"));
        phrasesList.add(new Word(99, "Reza, pero sigue remando"));
        phrasesList.add(new Word(99, "Rizar el rizo"));
        phrasesList.add(new Word(99, "Romper el hielo"));
        phrasesList.add(new Word(99, "Saber a gloria"));
        phrasesList.add(new Word(99, "Sacar las castañas del fuego"));
        phrasesList.add(new Word(99, "Salir del armario"));
        phrasesList.add(new Word(99, "Salirse de madre"));
        phrasesList.add(new Word(99, "Salud!"));
        phrasesList.add(new Word(99, "Salvarse por los pelos"));
        phrasesList.add(new Word(99, "Same here"));
        phrasesList.add(new Word(99, "Sarna con gusto no pica"));
        phrasesList.add(new Word(99, "Say when"));
        phrasesList.add(new Word(99, "Se le va la olla a alguien"));
        phrasesList.add(new Word(99, "Se me ha ido el santo al cielo"));
        phrasesList.add(new Word(99, "Seboso"));
        phrasesList.add(new Word(99, "Seco"));
        phrasesList.add(new Word(99, "Ser alguien de abultadas carnes"));
        phrasesList.add(new Word(99, "Ser alguien inmenso"));
        phrasesList.add(new Word(99, "Ser como el perro del hortelano, que ni come ni deja comer"));
        phrasesList.add(new Word(99, "Ser como un libro abierto"));
        phrasesList.add(new Word(99, "Ser de la cofradía del puño"));
        phrasesList.add(new Word(99, "Ser de la virgen del puño"));
        phrasesList.add(new Word(99, "Ser de piedra"));
        phrasesList.add(new Word(99, "Ser despedido"));
        phrasesList.add(new Word(99, "Ser flor de un día"));
        phrasesList.add(new Word(99, "Ser la hostia"));
        phrasesList.add(new Word(99, "Ser la oveja negra"));
        phrasesList.add(new Word(99, "Ser más caro el collar que el perro"));
        phrasesList.add(new Word(99, "Ser más corto que las mangas de un chaleco"));
        phrasesList.add(new Word(99, "Ser más papista que el Papa"));
        phrasesList.add(new Word(99, "Ser pan comido"));
        phrasesList.add(new Word(99, "Ser todo oídos (o ser toda oídos)"));
        phrasesList.add(new Word(99, "Ser un aguafiestas"));
        phrasesList.add(new Word(99, "Ser un bala perdida"));
        phrasesList.add(new Word(99, "Ser un chaquetero"));
        phrasesList.add(new Word(99, "Ser un correveidile"));
        phrasesList.add(new Word(99, "Ser un gorrón"));
        phrasesList.add(new Word(99, "Ser un manitas"));
        phrasesList.add(new Word(99, "Ser un pedazo de pan"));
        phrasesList.add(new Word(99, "Ser un peliculero"));
        phrasesList.add(new Word(99, "Ser un pelota"));
        phrasesList.add(new Word(99, "Ser un tiquismiquis"));
        phrasesList.add(new Word(99, "Ser una monada"));
        phrasesList.add(new Word(99, "Ser uña y carne"));
        phrasesList.add(new Word(99, "Si las barbas de tu vecino ves cortar, pon las tuyas a remojar"));
        phrasesList.add(new Word(99, "Si lloras por no haber visto el Sol las lágrimas te impedirán ver las estrellas"));
        phrasesList.add(new Word(99, "Siéntete como en tu casa"));
        phrasesList.add(new Word(99, "Sin comerlo ni beberlo"));
        phrasesList.add(new Word(99, "Sírvete"));
        phrasesList.add(new Word(99, "Sobre gustos no hay nada escrito"));
        phrasesList.add(new Word(99, "Ten cuidado!"));
        phrasesList.add(new Word(99, "Tener el mono"));
        phrasesList.add(new Word(99, "Tener enchufe"));
        phrasesList.add(new Word(99, "Tener huevos"));
        phrasesList.add(new Word(99, "Tener la mosca detrás de la oreja"));
        phrasesList.add(new Word(99, "Tener la sartén por el mango"));
        phrasesList.add(new Word(99, "Tener mala hostia"));
        phrasesList.add(new Word(99, "Tener más cara que espalda"));
        phrasesList.add(new Word(99, "Tener más cuento que Calleja"));
        phrasesList.add(new Word(99, "Tener mucho morro"));
        phrasesList.add(new Word(99, "Tener muchos tiros pegaos"));
        phrasesList.add(new Word(99, "Tener pocas luces"));
        phrasesList.add(new Word(99, "Tener un as en la manga"));
        phrasesList.add(new Word(99, "Tener un morro que se lo pisa"));
        phrasesList.add(new Word(99, "Tengo que irme"));
        phrasesList.add(new Word(99, "Tiene huevos la cosa"));
        phrasesList.add(new Word(99, "Tiene un par de huevos"));
        phrasesList.add(new Word(99, "Tirar de la manta"));
        phrasesList.add(new Word(99, "Tirar la piedra y esconder la mano"));
        phrasesList.add(new Word(99, "Tirar la toalla"));
        phrasesList.add(new Word(99, "Tirar los tejos"));
        phrasesList.add(new Word(99, "Tirarse los trastos a la cabeza"));
        phrasesList.add(new Word(99, "Tocando madera"));
        phrasesList.add(new Word(99, "Tocarse los huevos"));
        phrasesList.add(new Word(99, "Tócate los huevos"));
        phrasesList.add(new Word(99, "Tomamos la penúltima"));
        phrasesList.add(new Word(99, "Tomar el pelo"));
        phrasesList.add(new Word(99, "Tropezar dos veces con la misma piedra"));
        phrasesList.add(new Word(99, "Tú eliges"));
        phrasesList.add(new Word(99, "Un aguafiestas"));
        phrasesList.add(new Word(99, "Un día es un día"));
        phrasesList.add(new Word(99, "Una libra"));
        phrasesList.add(new Word(99, "Una resaca"));
        phrasesList.add(new Word(99, "Verse a la legua"));
        phrasesList.add(new Word(99, "Y un huevo"));
        phrasesList.add(new Word(99, "Yo también"));
        phrasesList.add(new Word(99, "Zapatero a tus zapatos"));
        return phrasesList;
    }
    
}
