<script>

  import Navbar from "@/components/Navbar.vue";

  export default {
    name: "UpdatePatient",
    components: {
      Navbar,
    },

    data() {
      return {
        patient: {
          id: '',
          name: '',
          email: '',
          gender: '',
          pNo: ''
        }
      }
    },

    beforeMount() {
      this.getPatients();
    },

    methods: {
      getPatients() {
        fetch(`http://localhost:8080/patients/${this.$route.params.id}`)
        .then(res => res.json())
        .then(data => {
          this.patients = data
          console.log(this.patients)
        })
      },

      updatePatient() {
        fetch('http://localhost:8080/patient', {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(this.patient)
        })
            .then(data => {
              console.log(data)
              this.$router.push("/")
            })
      }
    }

  }


</script>

<template>
  <main>
    <Navbar/>
    <div class="my-5">
      <div class="mx-auto w-25" style="max-width: 100%;">
        <h2 class="text-center">Update Patient</h2>
        <form @submit.prevent="updatePatient">
          <!-- name-->
          <div class="row">
            <div class="col-md-12 from-group mb-3">
              <label for="name" class="form-label">Name</label>
              <input type="text" name="name" id="name" class="form-control" placeholder="Name" required v-model="patient.name">
            </div>
          </div>
          <!-- email-->
          <div class="row">
            <div class="col-md-12 from-group mb-3">
              <label for="email" class="form-label">Email</label>
              <input type="email" name="email" id="email" class="form-control" placeholder="Email" required v-model="patient.email">
            </div>
          </div>
          <!-- pNo-->
          <div class="row">
            <div class="col-md-12 from-group mb-3">
              <label for="pNo" class="form-label">Phone number</label>
              <input type="text" name="pNo" id="pNo" class="form-control" placeholder="Phone number" required v-model="patient.pNo">
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 from-group mb-3">
              <input type="submit" value="Submit" class="btn btn-primary w-100">
            </div>
          </div>

        </form>
      </div>
    </div>

  </main>
</template>

<style>

</style>