import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { TestBlogModule } from './blog/blog.module';
import { TestEntryModule } from './entry/entry.module';
import { TestTagModule } from './tag/tag.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        TestBlogModule,
        TestEntryModule,
        TestTagModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TestEntityModule {}
