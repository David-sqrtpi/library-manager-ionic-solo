import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { CantidadDeLibrosPage } from './cantidad-de-libros.page';

describe('CantidadDeLibrosPage', () => {
  let component: CantidadDeLibrosPage;
  let fixture: ComponentFixture<CantidadDeLibrosPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CantidadDeLibrosPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(CantidadDeLibrosPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
