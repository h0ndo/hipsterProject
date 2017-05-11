import { Blog } from '../blog';
export class Entry {
    constructor(
        public id?: number,
        public title?: string,
        public content?: any,
        public date?: any,
        public blog?: Blog,
    ) {
    }
}
