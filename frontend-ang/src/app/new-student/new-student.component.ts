import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentsService} from "../services/students.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ConfirmationDialogComponent} from "../confirmation-dialog/confirmation-dialog.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-new-student',
  templateUrl: './new-student.component.html',
  styleUrl: './new-student.component.css'
})
export class NewStudentComponent implements OnInit {
  studentFormGroup!: FormGroup;
  showProgress: boolean = false;

  constructor(
    private fb: FormBuilder,
    private studentsService: StudentsService,
    private router: Router,
    private dialog: MatDialog
  ) {}

  ngOnInit() {
    // Initialisation du formulaire
    this.studentFormGroup = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      address: ['', Validators.required],
      zipCode: ['', Validators.required],
      city: ['', Validators.required],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      mail: ['', [Validators.required, Validators.email]],
      student: [true, Validators.required]
    });
  }

  saveStudent() {
    if (this.studentFormGroup.valid) {
      this.showProgress = true;
      const newStudent = this.studentFormGroup.value;

      // Appel au service pour ajouter un élève
      this.studentsService.addStudent(newStudent).subscribe({
        next: response => {
          console.log('Nouvel élève ajouté avec succès:', response);

          // Ouvrir le MatDialog avec un message de succès
          const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
            data: {
              title: 'Succès',
              message: 'L\'élève a été ajouté avec succès !'
            }
          });

          // Fermer le dialog après 3 secondes et rediriger vers la page des élèves
          setTimeout(() => {
            dialogRef.close(); // Ferme le dialog après 3 secondes
            this.router.navigate(['/admin/students']); // Redirige vers la page des élèves
          }, 3000); // 3 secondes, soit la durée d'affichage du message

          // Rediriger si l'utilisateur clique sur "OK"
          dialogRef.afterClosed().subscribe(() => {
            this.router.navigate(['/admin/students']); // Redirige vers la page des élèves après la fermeture du dialog
          });

          this.showProgress = false;
        },
        error: err => {
          console.error('Erreur lors de l\'ajout de l\'élève:', err);

          // Afficher une erreur avec le dialog si nécessaire
          this.dialog.open(ConfirmationDialogComponent, {
            data: {
              title: 'Erreur',
              message: 'Une erreur s\'est produite. Veuillez réessayer.'
            }
          });

          this.showProgress = false;
        }
      });
    } else {
      console.log('Formulaire invalide');
    }
  }
}
