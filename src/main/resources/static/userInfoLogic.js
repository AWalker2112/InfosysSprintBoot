

axios
.get("http://localhost:9092/person/getAll")
.then((response) => {
  console.log(response);
  const data = response
})
.catch((err) => {
    console.error(err);
  });


function getUserDetails(){

    let nameFirstName = document.getElementById("inputName1").value;
    let nameGender = document.getElementById("inputGender1").value;
    let nameAge = document.getElementById("inputAge1").value;
    console.log(nameFirstName);

    

}