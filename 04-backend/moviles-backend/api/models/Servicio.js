/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{
      type:'String'
    },
    fkUsuario:{//nombre del FK para la relación
      model:'usuario',
      //required:'true' //Opcional->siempre ingresar el FK
    }
  },

};

