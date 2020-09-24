import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { NuevoadminPage } from './nuevoadmin.page';

describe('NuevoadminPage', () => {
  let component: NuevoadminPage;
  let fixture: ComponentFixture<NuevoadminPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NuevoadminPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(NuevoadminPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
