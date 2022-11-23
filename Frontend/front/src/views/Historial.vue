<template>
    <img
        src="../playground_assets/imagen2022110220562846116177-tg1t-200h.png"
        alt="imagen2022110220562846116177"
        class="logo"
    />
    <div class="texto1">
        <pre>{{logo}}</pre>
    </div>
    <div class="cuadrado1" v-on:click="cuenta">
        <img
        src="../playground_assets/MisCuentas.png"
        alt="imagen2022110220562846116177"
        class="imagen1"
        />
        <span class="texto2">Mis Cuentas</span>
    </div>
    <div class="cuadrado2" v-on:click="historial">
        <img
        src="../playground_assets/HistorialTransacciones.png"
        alt="imagen2022110220562846116177"
        class="imagen2"
        />
        <pre class="texto3">{{titulo}}</pre>
    </div>
    <div class="cuadrado3" v-on:click="construccion">
        <img
        src="../playground_assets/realizarTransferencias.png"
        alt="imagen2022110220562846116177"
        class="imagen2"
        />
        <pre class="texto3">{{titulo2}}</pre>
    </div>
    <div class="cuadrado4" v-on:click="facturas">
        <img
        src="../playground_assets/pagosFacturas.png"
        alt="imagen2022110220562846116177"
        class="imagen3"
        />
        <pre class="texto4">Pagos de facturas</pre>
    </div>
    <div class="cuadrado5" v-on:click="construccion">
        <img
        src="../playground_assets/pagosServicios.png"
        alt="imagen2022110220562846116177"
        class="imagen4"
        />
        <pre class="texto4">Pagos de servicios</pre>
    </div>
    <div class="cuadrado6" v-on:click="construccion">
        <img
        src="../playground_assets/ajustes.svg"
        alt="imagen2022110220562846116177"
        class="imagen4"
        />
        <pre class="texto4">Ajustes</pre>
    </div>
    <img
        src="../playground_assets/division.svg"
        alt="imagen2022110220562846116177"
        class="imagen5"
        />
    <span class="texto5">Perfil</span>
    <span class="texto6">Nombre</span>
    <span class="texto7">Correo</span>
    <span class="texto8">Cuenta Corriente</span>
    <div class="cuadrado7" v-on:click="inicio">
        <img
        src="../playground_assets/logout.svg"
        alt="imagen2022110220562846116177"
        class="imagen6"
        />
        <pre class="textoCerrar">Cerrar Sesión</pre>
    </div>
    <!--Desde aqui ya no es la barra lateral-->
    <span class="texto9">Historial de transacciones</span>
    <span class="texto10">Aqui se encuentran las transacciones realizadas</span>
    <span class="texto11">N° de transacción</span>
    <span class="texto12">Nombre de depositante</span>
    <span class="texto13">Fecha</span>
    <span class="texto14">Hora</span>
    <span class="texto15">Monto</span>
    <div class="texto16">
      <div v-for="transferencia in transferencias" v-bind:key="transferencia.id" >
        <v-row>
            <input type="checkbox" id="transferencia.id" value="transferencia.numero" v-model="checkedNames">
            <label for="transferencia.id">{{ transferencia.numero }}</label>
        </v-row>
      </div>
    </div>
    <div class="texto17">
      <div v-for="transferencia in transferencias" v-bind:key="transferencia.id" >
        <v-row>
          <span  >{{ transferencia.nombre }}</span>
        </v-row>
      </div>
    </div>
    <div class="texto18">
      <div v-for="transferencia in transferencias" v-bind:key="transferencia.id" >
        <v-row>
          <span  >{{ transferencia.fecha }}</span>
        </v-row>
      </div>
    </div>
    <div class="texto19">
      <div v-for="transferencia in transferencias" v-bind:key="transferencia.id" >
        <v-row>
          <span  >{{ transferencia.hora }}</span>
        </v-row>
      </div>
    </div>
    <div class="texto20">
      <div v-for="transferencia in transferencias" v-bind:key="transferencia.id" >
        <v-row>
          <span  >{{ transferencia.monto }}</span>
        </v-row>
      </div>
    </div>
</template>
<script>
export default {
    name:'MisCuentas',
    data(){
        return{
            prueba:true,
            logo:'Inversiones\nRoyale',
            titulo:'Historial de\ntransacciones',
            titulo2:'Realizar\ntransferencias',
            transferencias:[{'id':1,'numero':123,'nombre':'nombre1','fecha':'17/03/22','hora':'15:31','monto':'10.000'},{'id':2,'numero':1234,'nombre':'nombre2','fecha':'17/12/22','hora':'18:31','monto':'20.000'}]
        }
    },
    methods:{
        cuenta(){
        this.$router.push("/MisCuentas")
        },
        historial(){
        this.$router.push("/Historial")
        },
        facturas(){
        this.$router.push("/Facturas")
        },
        construccion(){
            this.$router.push("/construccion")
        },
        inicio(){
            this.$router.push("/")
        }
    }
}
</script>
<style scoped>
.pre {
  width:100%;
  border: solid;
}
.logo {
  top: 20px;
  left: 20px;
  width: 200px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen1 {
  top: 10px;
  left: -80px;
  width: 75px;
  height: 70px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen2 {
  top: 10px;
  left: -80px;
  width: 74px;
  height: 76px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen3 {
  top: 10px;
  left: -95px;
  width: 74px;
  height: 76px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen4 {
  top: 10px;
  left: -100px;
  width: 74px;
  height: 76px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen5 {
  top:950px;
  left: 20px;
  width: 350px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.imagen6 {
  top:0px;
  left: -70px;
  width: 30px;
  height: 15px;
  position: relative;
  box-sizing: border-box;
  object-fit: cover;
  border-width: 1px;
  border-radius: 4px;
}
.texto1 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 30px;
  left: 230px;
  font-size: 25px;
  color:#059669
}
.texto2 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -40px;
  left: 120px;
  font-size: 22px;
}
.texto3 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -80px;
  left: 120px;
  font-size: 22px;
}
.texto4 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -70px;
  left: 105px;
  font-size: 22px;
}
.texto5 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 975px;
  left: 50px;
  font-size: 22px;
  color:#64748B;
}
.texto6 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 1025px;
  left: 50px;
  font-size: 18px;
}
.texto7 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 1050px;
  left: 50px;
  font-size: 18px;
  color:#A0ABBB
}
.texto8 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 1075px;
  left: 50px;
  font-size: 18px;
}
.texto9 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 50px;
  left: 430px;
  font-size: 40px;
  color:#059669
}
.texto10 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 95px;
  left: 430px;
  font-size: 22px;
  color:#64748B
}
.texto11 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 150px;
  left: 430px;
  font-size: 17px;
  color:#64748B
}
.texto12 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 150px;
  left: 650px;
  font-size: 17px;
  color:#64748B
}
.texto13 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 150px;
  left: 920px;
  font-size: 17px;
  color:#64748B
}
.texto14 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 150px;
  left: 1050px;
  font-size: 17px;
  color:#64748B
}
.texto15{
    display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 150px;
  left: 1150px;
  font-size: 17px;
  color:#64748B
}
.texto16{
    display: flex;
    position: absolute;
    align-self: stretch;
    align-items: flex-start;
    border-color: transparent;
    margin-bottom: 24px;
    flex-direction: column;
    font-weight: bolder;
    top: 200px;
    left: 430px;
    font-size: 17px;
}
.texto17 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 200px;
  left: 650px;
  font-size: 17px;
}
.texto18 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 200px;
  left: 920px;
  font-size: 17px;
}
.texto19 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 200px;
  left: 1050px;
  font-size: 17px;
}
.texto20{
    display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 200px;
  left: 1150px;
  font-size: 17px;
}
.textoCerrar {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: -40px;
  left: 105px;
  font-size: 17px;
}
.cuadrado1 {
  top:200px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado2 {
  top:325px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #E7EAEE;
  cursor: pointer;
}
.cuadrado3 {
  top:450px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado4 {
  top:575px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado5 {
  top:700px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado6 {
  top:825px;
  left: 20px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
.cuadrado7{
  top:1110px;
  left: 10px;
  width: 320px;
  height: 100px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  background-color: #ffffff;
  cursor: pointer;
}
</style>